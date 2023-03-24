package com.acme.order.itrade;

public class ReferenceIdentification {
    private String referenceIdentificationQualifier;
    private String referenceIdentificationCode;

    public String getReferenceIdentificationQualifier() {
        return referenceIdentificationQualifier;
    }

    public void setReferenceIdentificationQualifier(String referenceIdentificationQualifier) {
        this.referenceIdentificationQualifier = referenceIdentificationQualifier;
    }

    public String getReferenceIdentificationCode() {
        return referenceIdentificationCode;
    }

    public void setReferenceIdentificationCode(String referenceIdentificationCode) {
        this.referenceIdentificationCode = referenceIdentificationCode;
    }


    @Override
    public String toString() {
        return "\treferenceIdentificationQualifier='" + referenceIdentificationQualifier + '\'' +
                ", referenceIdentificationCode='" + referenceIdentificationCode;
    }
}
