package autumn.twilightforest.init.entity.client.wild_deer

import net.minecraft.client.render.entity.animation.AnimationDefinition
import net.minecraft.client.render.entity.animation.AnimationHelper
import net.minecraft.client.render.entity.animation.Keyframe
import net.minecraft.client.render.entity.animation.Transformation

object WildDeerAnim {
    val ANIM_WILD_DEER_WALK: AnimationDefinition? = AnimationDefinition.Builder.create(1.0f).looping()
        .addBoneAnimation(
            "head", Transformation(
                Transformation.Targets.MOVE_ORIGIN,
                Keyframe(
                    0.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.25f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.25f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "bl_leg", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createRotationalVector(10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createRotationalVector(-10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "fl_leg", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createRotationalVector(-10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createRotationalVector(10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "br_leg", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createRotationalVector(-10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createRotationalVector(10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "fr_leg", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createRotationalVector(10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createRotationalVector(-10.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .build()

    val ANIM_WILD_DEER_EAT: AnimationDefinition? = AnimationDefinition.Builder.create(7.5f)
        .addBoneAnimation(
            "head", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(50.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.5f,
                    AnimationHelper.createRotationalVector(50.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "head", Transformation(
                Transformation.Targets.MOVE_ORIGIN,
                Keyframe(
                    0.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createTranslationalVector(0.0f, -16.0f, -2.0f),
                    Transformation.Interpolations.CUBIC
                ),
                Keyframe(
                    6.5f,
                    AnimationHelper.createTranslationalVector(0.0f, -16.0f, -2.0f),
                    Transformation.Interpolations.CUBIC
                ),
                Keyframe(
                    7.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "neck", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(115.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.5f,
                    AnimationHelper.createRotationalVector(115.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .build()
}