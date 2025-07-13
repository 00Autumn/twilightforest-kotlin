package autumn.twilightforest.init.entity.client.tiny_bird

import net.minecraft.client.render.entity.animation.AnimationDefinition
import net.minecraft.client.render.entity.animation.AnimationHelper
import net.minecraft.client.render.entity.animation.Keyframe
import net.minecraft.client.render.entity.animation.Transformation

object TinyBirdAnim {
    val ANIM_TINY_BIRD_WALK: AnimationDefinition? = AnimationDefinition.Builder.create(0.75f).looping()
        .addBoneAnimation("head", Transformation(Transformation.Targets.MOVE_ORIGIN,
                Keyframe(0.0f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.25f, AnimationHelper.createTranslationalVector(0.0f, -0.1f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.5f, AnimationHelper.createTranslationalVector(0.0f, 0.1f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.75f, AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR)))
        .addBoneAnimation("r_wing", Transformation(Transformation.Targets.ROTATE,
                Keyframe(0.0f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.25f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 1.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.5f, AnimationHelper.createRotationalVector(0.0f, 0.0f, -1.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.75f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("l_wing", Transformation(Transformation.Targets.ROTATE, Keyframe(0.0f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.25f, AnimationHelper.createRotationalVector(0.0f, 0.0f, -1.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.5f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 1.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.75f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("l_foot", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.25f, AnimationHelper.createRotationalVector(10.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.5f, AnimationHelper.createRotationalVector(-10.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.75f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("r_foot", Transformation(Transformation.Targets.ROTATE, Keyframe(0.0f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.25f, AnimationHelper.createRotationalVector(-10.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.5f, AnimationHelper.createRotationalVector(10.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR),
                Keyframe(0.75f, AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f), Transformation.Interpolations.LINEAR)
        ))
        .build()

    val ANIM_TINY_BIRD_FLY: AnimationDefinition? = AnimationDefinition.Builder.create(10.0f)
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
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.45f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    10.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "body", Transformation(
                Transformation.Targets.MOVE_ORIGIN,
                Keyframe(
                    0.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.25f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.75f,
                    AnimationHelper.createTranslationalVector(0.0f, -0.35f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    10.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "r_wing", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    10.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 20.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "l_wing", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    1.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    2.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    3.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    4.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    5.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    6.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    7.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    8.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.25f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.5f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.75f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -120.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    10.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, -20.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "l_foot", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(87.5f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.5f,
                    AnimationHelper.createRotationalVector(87.5f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    10.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "r_foot", Transformation(
                Transformation.Targets.ROTATE,
                Keyframe(
                    0.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createRotationalVector(87.5f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.5f,
                    AnimationHelper.createRotationalVector(87.5f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    10.0f,
                    AnimationHelper.createRotationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .addBoneAnimation(
            "tiny_bird", Transformation(
                Transformation.Targets.MOVE_ORIGIN,
                Keyframe(
                    0.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    0.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 64.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    9.5f,
                    AnimationHelper.createTranslationalVector(0.0f, 64.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                ),
                Keyframe(
                    10.0f,
                    AnimationHelper.createTranslationalVector(0.0f, 0.0f, 0.0f),
                    Transformation.Interpolations.LINEAR
                )
            )
        )
        .build()
}