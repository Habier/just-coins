package com.javigar.justcoins;

import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinCommand extends CommandBase {
    private static List<String> values = Arrays.asList("copper", "silver", "gold", "sack");

    /**
     * Gets the name of the command
     */
    @Override
    public String getName() {
        return "coin";
    }

    /**
     * Gets the usage string for the command.
     */
    @Override
    public String getUsage(ICommandSender icommandsender) {
        return "/coin <Player> <copper|silver|gold|sack> [quantity]";
    }

    /**
     * Return the required permission level for this command.
     */
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    /**
     * Callback for when the command is executed
     */
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 2) {
            throw new WrongUsageException("commands.coin.usage");
        } else {
            EntityPlayer entityplayer = getPlayer(server, sender, args[0]);
            Item item = getItemByText(sender, "justcoins:" + args[1] + "_coin");
            int i = args.length >= 3 ? parseInt(args[2], 1, item.getItemStackLimit()) : 1;
            int j = args.length >= 4 ? parseInt(args[3]) : 0;
            ItemStack itemstack = new ItemStack(item, i, j);

            ItemHandlerHelper.giveItemToPlayer(entityplayer, itemstack, -1);

            //notifyCommandListener(sender, this, "commands.coin.success", new Object[]{itemstack.getTextComponent(), i, entityplayer.getName()});
        }
    }

    /**
     * Get a list of options for when the user presses the TAB key
     */
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
        } else {
            return args.length == 2 ? getListOfStringsMatchingLastWord(args, values) : Collections.emptyList();
        }

    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] args, int index) {
        return index == 0;
    }


}
