package net.dispider.dispidermod.entity;

import net.dispider.dispidermod.DiSpiderMod;
import net.dispider.dispidermod.entity.custom.MasterBallProjectileEntity;
import net.dispider.dispidermod.entity.custom.PokeballProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DiSpiderMod.EXAMPLEMOD);
    public static final RegistryObject<EntityType<PokeballProjectileEntity>> POKEBALL_PROJECTILE =
            ENTITY_TYPES.register("pokeball_projectile", () -> EntityType.Builder.<PokeballProjectileEntity>of(PokeballProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("pokeball_projectile"));

    public static final RegistryObject<EntityType<PokeballProjectileEntity>> SkeletonPOKEBALL_PROJECTILE =
            ENTITY_TYPES.register("skeleton_pokeball_projectile", () -> EntityType.Builder.<PokeballProjectileEntity>of(PokeballProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("skeleton_pokeball_projectile"));


    public static final RegistryObject<EntityType<PokeballProjectileEntity>> SlimePOKEBALL_PROJECTILE =
            ENTITY_TYPES.register("slime_pokeball_projectile", () -> EntityType.Builder.<PokeballProjectileEntity>of(PokeballProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("slime_pokeball_projectile"));

    public static final RegistryObject<EntityType<PokeballProjectileEntity>> zombiePOKEBALL_PROJECTILE =
            ENTITY_TYPES.register("zombie_pokeball_projectile", () -> EntityType.Builder.<PokeballProjectileEntity>of(PokeballProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("zombie_pokeball_projectile"));

    public static final RegistryObject<EntityType<PokeballProjectileEntity>> spidercreeperPOKEBALL_PROJECTILE =
            ENTITY_TYPES.register("spider_pokeball_projectile", () -> EntityType.Builder.<PokeballProjectileEntity>of(PokeballProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("spider_pokeball_projectile"));

    public static final RegistryObject<EntityType<PokeballProjectileEntity>> creeperPOKEBALL_PROJECTILE =
            ENTITY_TYPES.register("creeper_pokeball_projectile", () -> EntityType.Builder.<PokeballProjectileEntity>of(PokeballProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("creeper_pokeball_projectile"));

    public static final RegistryObject<EntityType<MasterBallProjectileEntity>> Masterball_PROJECTILE =
            ENTITY_TYPES.register("masterball_projectile", () -> EntityType.Builder.<MasterBallProjectileEntity>of(MasterBallProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("masterball_projectile"));

    public static final RegistryObject<EntityType<MasterBallProjectileEntity>> EnderDragonPROJECTILE =
            ENTITY_TYPES.register("ender_masterball_dragon_projectile", () -> EntityType.Builder.<MasterBallProjectileEntity>of(MasterBallProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("ender_dragon_masterball_projectile"));

    public static final RegistryObject<EntityType<MasterBallProjectileEntity>> WitherPROJECTILE =
            ENTITY_TYPES.register("wither_masterball_projectile", () -> EntityType.Builder.<MasterBallProjectileEntity>of(MasterBallProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("wither_masterball_projectile"));


    public static void register(IEventBus eventBus){ENTITY_TYPES.register(eventBus);
    }

}
