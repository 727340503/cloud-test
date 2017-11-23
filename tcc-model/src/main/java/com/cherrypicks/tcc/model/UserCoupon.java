package com.cherrypicks.tcc.model;

import java.util.Date;
public class UserCoupon extends BaseModel {
    /** 版本号 */
    private static final long serialVersionUID = -4070924742078995137L;

    public enum UserCouponStatus {
        ACTIVE(1),REDEEMED(2);

        private final int value;

        UserCouponStatus(final int value) {
            this.value = value;
        }

        public int toValue() {
            return this.value;
        }
    }

    /**  */
    private Long userId;

    private Long merchantId;

    /**  */
    private Long couponId;

    /** 1- Active 2- Redeemed */
    private Integer status;

    /**  */

    private String qrCode;

    /**  */

    private Date redeemedDate;

    /**
     * 获取
     *
     * @return
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * 设置
     *
     * @param userId
     *
     */
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    /**
     * 获取1- Active 2- Redeemed
     *
     * @return 1- Active 2- Redeemed
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置1- Active 2- Redeemed
     *
     * @param status
     *          1- Active 2- Redeemed
     */
    public void setStatus(final Integer status) {
        this.status = status;
    }

    /**
     * 获取
     *
     * @return
     */
    public Date getRedeemedDate() {
        return this.redeemedDate;
    }

    /**
     * 设置
     *
     * @param redeemedDate
     *
     */
    public void setRedeemedDate(final Date redeemedDate) {
        this.redeemedDate = redeemedDate;
    }

    /**
     * 获取
     *
     * @return
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * 设置
     *
     * @param couponId
     *
     */
    public void setCouponId(final Long couponId) {
        this.couponId = couponId;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * 设置
     *
     * @param qrCode
     *
     */
    public void setQrCode(final String qrCode) {
        this.qrCode = qrCode;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(final Long merchantId) {
        this.merchantId = merchantId;
    }


}