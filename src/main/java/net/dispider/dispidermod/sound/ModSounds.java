package net.dispider.dispidermod.sound;

import net.dispider.dispidermod.DiSpiderMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DiSpiderMod.MODID);

    public static final RegistryObject<SoundEvent> EPIC_BOW_SHOOT = registerSoundEvent("chisel.use");

    public static final RegistryObject<SoundEvent> useVape = registerSoundEvent("use_vape");

    public static final RegistryObject<SoundEvent> kunaiThrow = registerSoundEvent("kunaithrow");

    public static final RegistryObject<SoundEvent> Ninja = registerSoundEvent("ninja");

    public static final RegistryObject<SoundEvent> Moontale = registerSoundEvent("moontale");

    public static final RegistryObject<SoundEvent> KatanaSlash = registerSoundEvent("katanaslash");
    public static final RegistryObject<SoundEvent> KatanaBigSlash = registerSoundEvent("katanabigslash");

    public static final RegistryObject<SoundEvent> Appa_Idle = registerSoundEvent("idle");

    public static final RegistryObject<SoundEvent> Appa_Hurt = registerSoundEvent("attacked");

    public static final ResourceKey<JukeboxSong> Moontale_Key = ResourceKey.create(Registries.JUKEBOX_SONG,ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID,"moontale"));

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENTS.register(name,()->SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(DiSpiderMod.MODID,name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);

    }

}
