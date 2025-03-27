package net.dispider.dispidermod.entity.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class GronAnimations {
    public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(3.0F)
            .addAnimation("bone12", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("bone12", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("bone12", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("bone13", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5F, KeyframeAnimations.scaleVec(1.0F, 0.9F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("fire", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 115.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 130.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("fire2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 59.9F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -67.6F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 37.4F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("fire3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 120.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 47.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("fire4", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -102.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 122.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("fires", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();

    public static final AnimationDefinition walk = AnimationDefinition.Builder.withLength(7.0F)
            .addAnimation("bone12", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, -45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(7.0F, KeyframeAnimations.degreeVec(0.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("bone13", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(0.0F, 45.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(7.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Ola", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Ola", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(7.0F, KeyframeAnimations.posVec(0.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("Ola", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("bone15", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("bone15", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.posVec(0.0F, 8.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("bone15", new AnimationChannel(AnimationChannel.Targets.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.0F, KeyframeAnimations.scaleVec(1.0F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.0F, KeyframeAnimations.scaleVec(1.0F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();
}
