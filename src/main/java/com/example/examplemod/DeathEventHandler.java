package com.example.examplemod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class DeathEventHandler {
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void LivingDeathEvent(LivingDeathEvent e) {
		try {
			FileWriter myfile = new FileWriter("/home/alice/died.txt");
			EntityLivingBase entity = e.getEntityLiving();
			myfile.write(e.getSource().getDeathMessage(entity).getUnformattedComponentText());
			myfile.close();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
