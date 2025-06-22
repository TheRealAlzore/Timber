package cc.timber.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandsTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            completions.add("enable");
            completions.add("disable");
            if (sender.hasPermission("timber.reload")) {
                completions.add("reload");
            }
            return filterCompletions(completions, args[0]);
        }
        return Collections.emptyList();
    }
    private List<String> filterCompletions(List<String> options, String currentInput) {
        List<String> filtered = new ArrayList<>();
        for (String option : options) {
            if (option.toLowerCase().startsWith(currentInput.toLowerCase())) {
                filtered.add(option);
            }
        }
        return filtered;
    }
}