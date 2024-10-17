<template>
    <el-dialog :model-value="props.visible" :title="props.title" :width="props.width + 'px'" :before-close="onClose">
        <!-- 内容显示区域 -->
        <div class="container" :style="{ height: height + 'px' }">
            <slot name="content"></slot>
        </div>
        <template #footer>
            <span class="dialog-footer">
                <el-button type="danger" @click="onClose">取消</el-button>
                <el-button type="primary" @click="onConfirm">确定</el-button>
            </span>
        </template>
    </el-dialog>
</template>

<script setup lang="ts">
//弹窗数据类型
interface DialogProps {
    title: string,
    visible: boolean,
    width: number,
    height: number
}
//接收父组件传递参数
const props = withDefaults(defineProps<DialogProps>(), {
    title: '标题',
    visible: false,
    width: 630,
    height: 280
})
const emit = defineEmits(["onClose", "onConfirm"]);
//定义弹框的关闭
const onClose = () => {
    emit("onClose");
}
//定义弹框的确定
const onConfirm = () => {
    emit("onConfirm");
}
</script>

<style lang="scss" scope>
.container {
    overflow-x: initial;
    overflow-y: auto;
}

.el-dialog {
    border-top-left-radius: 7px !important;
    border-top-right-radius: 7px !important;
    padding: 0;


    .el-dialog__header {
        line-height: 39px;
        border-top-left-radius: 7px !important;
        border-top-right-radius: 7px !important;
        background-color: #17223b !important;


        .el-dialog__title {
            color: #fff;
            font-size: 16px;
            font-weight: 600;
            margin-left: 20px;
        }
    }

    .el-dialog__headerbtn {
        .el-dialog__close {
            color: #fff;
        }
    }

    .el-dialog__body {
        padding: 10px;
    }

    .el-dialog__footer {
        border-top: 1px solid #e8eaec !important;
        padding: 10px;
    }
}
</style>