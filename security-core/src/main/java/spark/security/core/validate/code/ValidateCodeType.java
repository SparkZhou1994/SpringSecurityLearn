package spark.security.core.validate.code;

import spark.security.core.properties.SecurityConstants;

public enum ValidateCodeType {
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };
    public abstract String getParamNameOnValidate();
}
