package com.cachexic.cloud.common.exceptions;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

import javax.annotation.Nullable;

/**
 * @author tangmin
 * @Description: 模仿guava的Preconditions check预设条件,抛出业务异常，以便统一异常处理
 * @date 2017-09-01 23:10:27
 */
public final class BizPreconditions {
    private BizPreconditions() {}

    /**
     * 校验参数
     * @param expression
     */
    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new BizException(BizExceptionEnum.PARAMETER_ERROR);
        }
    }

    public static void checkArgument(boolean expression,@Nullable Object errorMessage) {
        if (!expression) {
            throw new BizException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(
            boolean expression,
            @Nullable String errorMessageTemplate,
            @Nullable Object... errorMessageArgs) {
        if (!expression) {
            throw new BizException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    /**
     * 判断状态
     * @param expression
     */
    public static void checkState(boolean expression) {
        if (!expression) {
            throw new BizException(BizExceptionEnum.STATE_ERROR);
        }
    }

    public static void checkState(boolean expression,@Nullable Object errorMessage) {
        if (!expression) {
            throw new BizException(String.valueOf(errorMessage));
        }
    }

    public static void checkState(
            boolean expression,
            @Nullable String errorMessageTemplate,
            @Nullable Object... errorMessageArgs) {
        if (!expression) {
            throw new BizException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    /**
     * 校验是否为空，并返回结果，可以用于赋值
     * @param reference
     * @param <T>
     * @return
     */
    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new BizException(BizExceptionEnum.NULL_ERROR);
        }
        return reference;
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if (reference == null) {
            throw new BizException(String.valueOf(errorMessage));
        }
        return reference;
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(
            T reference, @Nullable String errorMessageTemplate, @Nullable Object... errorMessageArgs) {
        if (reference == null) {
            // If either of these parameters is null, the right thing happens anyway
            throw new BizException(format(errorMessageTemplate, errorMessageArgs));
        }
        return reference;
    }

    static String format(String template, @Nullable Object... args) {
        template = String.valueOf(template); // null -> "null"

        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template, templateStart, placeholderStart);
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template, templateStart, template.length());

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }

        return builder.toString();
    }


}
