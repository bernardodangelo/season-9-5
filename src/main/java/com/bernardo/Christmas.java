package com.bernardo;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Random;

public class Christmas implements Listener {

    Random random = new Random();

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){

        if(random.nextDouble() < .08) {
            event.getDrops().add(new ItemStack(Material.COOKIE, 1));
        }
    }


    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.ZOMBIE || event.getEntityType() == EntityType.SKELETON || event.getEntityType() == EntityType.WITHER_SKELETON) {
            LivingEntity mob = (LivingEntity) event.getEntity();

            ItemStack redHelmet = new ItemStack(Material.LEATHER_HELMET, 1);
            LeatherArmorMeta meta = (LeatherArmorMeta) redHelmet.getItemMeta();
            meta.setColor(org.bukkit.Color.RED);
            redHelmet.setItemMeta(meta);

            mob.getEquipment().setHelmet(redHelmet);
        }
    }

}
