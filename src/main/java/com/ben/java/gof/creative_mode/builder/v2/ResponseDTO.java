//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ben.java.gof.creative_mode.builder.v2;

import java.io.Serializable;

public class ResponseDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int returnCode;
    private String returnMsg;
    private boolean success;
    private T result;
    private Long currentTime;

    public ResponseDTO(int returnCode, String returnMsg, T data) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.result = data;
    }

    private static <T> boolean $default$success() {
        return true;
    }

    private static <T> Long $default$currentTime() {
        return System.currentTimeMillis();
    }

    public static <T> ResponseDTOBuilder<T> builder() {
        return new ResponseDTOBuilder();
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getReturnMsg() {
        return this.returnMsg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getResult() {
        return this.result;
    }

    public Long getCurrentTime() {
        return this.currentTime;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseDTO)) {
            return false;
        } else {
            ResponseDTO<?> other = (ResponseDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getReturnCode() != other.getReturnCode()) {
                return false;
            } else {
                Object this$returnMsg = this.getReturnMsg();
                Object other$returnMsg = other.getReturnMsg();
                if (this$returnMsg == null) {
                    if (other$returnMsg != null) {
                        return false;
                    }
                } else if (!this$returnMsg.equals(other$returnMsg)) {
                    return false;
                }

                if (this.isSuccess() != other.isSuccess()) {
                    return false;
                } else {
                    Object this$result = this.getResult();
                    Object other$result = other.getResult();
                    if (this$result == null) {
                        if (other$result != null) {
                            return false;
                        }
                    } else if (!this$result.equals(other$result)) {
                        return false;
                    }

                    Object this$currentTime = this.getCurrentTime();
                    Object other$currentTime = other.getCurrentTime();
                    if (this$currentTime == null) {
                        if (other$currentTime != null) {
                            return false;
                        }
                    } else if (!this$currentTime.equals(other$currentTime)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ResponseDTO;
    }

    public int hashCode() {
        // int PRIME = true;
        int result = 1;
        result = result * 59 + this.getReturnCode();
        Object $returnMsg = this.getReturnMsg();
        result = result * 59 + ($returnMsg == null ? 43 : $returnMsg.hashCode());
        result = result * 59 + (this.isSuccess() ? 79 : 97);
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        Object $currentTime = this.getCurrentTime();
        result = result * 59 + ($currentTime == null ? 43 : $currentTime.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseDTO(returnCode=" + this.getReturnCode() + ", returnMsg=" + this.getReturnMsg() + ", success=" + this.isSuccess() + ", result=" + this.getResult() + ", currentTime=" + this.getCurrentTime() + ")";
    }

    public ResponseDTO(int returnCode, String returnMsg, boolean success, T result, Long currentTime) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.success = success;
        this.result = result;
        this.currentTime = currentTime;
    }

    public ResponseDTO() {
        this.success = $default$success();
        this.currentTime = $default$currentTime();
    }

    public static class ResponseDTOBuilder<T> {
        private int returnCode;
        private String returnMsg;
        private boolean success$set;
        private boolean success;
        private T result;
        private boolean currentTime$set;
        private Long currentTime;

        ResponseDTOBuilder() {
        }

        public ResponseDTOBuilder<T> returnCode(int returnCode) {
            this.returnCode = returnCode;
            return this;
        }

        public ResponseDTOBuilder<T> returnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
            return this;
        }

        public ResponseDTOBuilder<T> success(boolean success) {
            this.success = success;
            this.success$set = true;
            return this;
        }

        public ResponseDTOBuilder<T> result(T result) {
            this.result = result;
            return this;
        }

        public ResponseDTOBuilder<T> currentTime(Long currentTime) {
            this.currentTime = currentTime;
            this.currentTime$set = true;
            return this;
        }

        public ResponseDTO<T> build() {
            boolean success = this.success;
            if (!this.success$set) {
                success = ResponseDTO.$default$success();
            }

            Long currentTime = this.currentTime;
            if (!this.currentTime$set) {
                currentTime = ResponseDTO.$default$currentTime();
            }

            return new ResponseDTO(this.returnCode, this.returnMsg, success, this.result, currentTime);
        }

        public String toString() {
            return "ResponseDTO.ResponseDTOBuilder(returnCode=" + this.returnCode + ", returnMsg=" + this.returnMsg + ", success=" + this.success + ", result=" + this.result + ", currentTime=" + this.currentTime + ")";
        }
    }
}
