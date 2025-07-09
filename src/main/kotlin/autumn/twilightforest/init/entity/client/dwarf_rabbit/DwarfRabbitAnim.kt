package autumn.twilightforest.init.entity.client.dwarf_rabbit

import net.minecraft.client.render.entity.animation.AnimationDefinition
import net.minecraft.client.render.entity.animation.AnimationHelper
import net.minecraft.client.render.entity.animation.Keyframe
import net.minecraft.client.render.entity.animation.Transformation

object DwarfRabbitAnim {
    val ANIM_DWARF_RABBIT_REST: AnimationDefinition? = AnimationDefinition.Builder.create(0.25f)
        .addBoneAnimation("head", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.85f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("body", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.85f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("fr_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(-35f, 0f, -45f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("fr_leg", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("br_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(-35f, 0f, 45f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("br_leg", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("fl_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(35f, 0f, -45f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("fl_leg", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("bl_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(35f, 0f, 45f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("bl_leg", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.5f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("tail", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("tail", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0.5f, -2f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("r_ear", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("r_ear", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.85f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("l_ear", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -10f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("l_ear", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.85f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .build()

    val ANIM_DWARF_RABBIT_WALK: AnimationDefinition? = AnimationDefinition.Builder.create(0.75f).looping()
        .addBoneAnimation("head", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("fr_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("br_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("fl_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("bl_leg", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 15f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("tail", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("r_ear", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, -1f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 1f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("r_ear", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("l_ear", Transformation(Transformation.Targets.ROTATE,
            Keyframe(0.0f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 1f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, -1f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .addBoneAnimation("l_ear", Transformation(Transformation.Targets.MOVE_ORIGIN,
            Keyframe(0.0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f), Transformation.Interpolations.LINEAR),
            Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f), Transformation.Interpolations.LINEAR)
        ))
        .build()
}