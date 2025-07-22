package autumn.twilightforest.init.entity.client.knight_phantom

import net.minecraft.client.render.entity.animation.AnimationDefinition
import net.minecraft.client.render.entity.animation.AnimationHelper
import net.minecraft.client.render.entity.animation.Keyframe
import net.minecraft.client.render.entity.animation.Transformation

object KnightPhantomAnim {
    val ANIM_KNIGHT_PHANTOM_FLOAT: AnimationDefinition = AnimationDefinition.Builder.create(4.0f).looping()
        .addBoneAnimation("head", Transformation(
            Transformation.Targets.MOVE_ORIGIN,
            Keyframe(
                0.0f,
                AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                Transformation.Interpolations.LINEAR
            ),
            Keyframe(
                1.0f,
                AnimationHelper.createTranslationalVector(0.0f, 3.0f, 0.0f),
                Transformation.Interpolations.LINEAR
            ),
            Keyframe(
                2.0f,
                AnimationHelper.createTranslationalVector(0.0f, -1.0f, 0.0f),
                Transformation.Interpolations.LINEAR
            ),
            Keyframe(
                3.0f,
                AnimationHelper.createTranslationalVector(0.0f, 2.0f, 0.0f),
                Transformation.Interpolations.LINEAR
            ),
            Keyframe(
                4.0f,
                AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                Transformation.Interpolations.LINEAR
            ),
        )
        )
        .addBoneAnimation("hat", Transformation(
            Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(1.0f, AnimationHelper.createTranslationalVector(0.0f, 3.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(2.0f, AnimationHelper.createTranslationalVector(0.0f, -1.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(3.0f, AnimationHelper.createTranslationalVector(0.0f, 2.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(4.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
        ))
        .addBoneAnimation("body", Transformation(
            Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(1.0f, AnimationHelper.createTranslationalVector(0.0f, 3.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(2.0f, AnimationHelper.createTranslationalVector(0.0f, -1.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(3.0f, AnimationHelper.createTranslationalVector(0.0f, 2.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(4.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
        ))
        .addBoneAnimation("left_arm", Transformation(
            Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(1.0f, AnimationHelper.createTranslationalVector(0.0f, 3.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(2.0f, AnimationHelper.createTranslationalVector(0.0f, -1.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(3.0f, AnimationHelper.createTranslationalVector(0.0f, 2.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(4.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
        ))
        .addBoneAnimation("right_arm", Transformation(
            Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(1.0f, AnimationHelper.createTranslationalVector(0.0f, 3.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(2.0f, AnimationHelper.createTranslationalVector(0.0f, -1.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(3.0f, AnimationHelper.createTranslationalVector(0.0f, 2.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(4.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
        ))
        .addBoneAnimation("left_leg", Transformation(
            Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(1.0f, AnimationHelper.createTranslationalVector(0.0f, 3.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(2.0f, AnimationHelper.createTranslationalVector(0.0f, -1.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(3.0f, AnimationHelper.createTranslationalVector(0.0f, 2.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(4.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
        ))
        .addBoneAnimation("right_leg", Transformation(
            Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(1.0f, AnimationHelper.createTranslationalVector(0.0f, 3.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(2.0f, AnimationHelper.createTranslationalVector(0.0f, -1.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(3.0f, AnimationHelper.createTranslationalVector(0.0f, 2.0f, 0.0f), Transformation.Interpolations.LINEAR),
            Keyframe(4.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
        ))
        .build()
}