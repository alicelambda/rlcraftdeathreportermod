package com.example.examplemod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class DeathEventHandler {

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void LivingDeathEvent(LivingDeathEvent e) {
		EntityLivingBase entity = e.getEntityLiving();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			try {
				FileWriter myfile = new FileWriter("/home/alice/died.txt", true);
				BufferedWriter bw = new BufferedWriter(myfile);
				bw.write(e.getSource().getDeathMessage(entity).getUnformattedComponentText() + "," + player.getScore() + "\n");
				bw.close();
				myfile.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
