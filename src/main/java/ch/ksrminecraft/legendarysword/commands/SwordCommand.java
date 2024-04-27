package ch.ksrminecraft.legendarysword.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SwordCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        // CommandSender in einen Spieler Casten
        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        // Erstellen eines Item-Stacks vom Typ Netherite-Schwert
        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD, 1);

        // Herauslesen der Mata-Daten des Schwerts
        ItemMeta meta_sword = sword.getItemMeta();

        // Ändern der Meta-Daten
        meta_sword.displayName(Component.text("Legendäres Schwert"));
        meta_sword.addEnchant(Enchantment.SWEEPING_EDGE, 100, true);
        meta_sword.addEnchant(Enchantment.LOOT_BONUS_MOBS, 100, true);
        meta_sword.addEnchant(Enchantment.DURABILITY, 100, true);
        meta_sword.addEnchant(Enchantment.DAMAGE_ALL, 100, true);

        // Hinzufügen einer Lore
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_RED + "Ein legendäres Schwert");
        lore.add(ChatColor.DARK_BLUE + "Benutze es weise");
        meta_sword.setLore(lore);

        // Zurückschreiben der Meta-Daten und Item in Spielerinventar legen
        sword.setItemMeta(meta_sword);
        player.getInventory().addItem(sword);

        return true;
    }
}
