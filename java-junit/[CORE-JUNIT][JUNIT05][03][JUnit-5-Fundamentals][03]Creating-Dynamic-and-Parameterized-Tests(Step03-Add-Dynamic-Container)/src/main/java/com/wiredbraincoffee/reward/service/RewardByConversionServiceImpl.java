package com.wiredbraincoffee.reward.service;

import java.util.List;

import com.wiredbraincoffee.product.entity.Product;
import com.wiredbraincoffee.reward.entity.RewardInformation;

/**
 * @author knguyen97
 *
 */
public class RewardByConversionServiceImpl extends RewardServiceAbstract {
    private double amount;

    
    
    /* (non-Javadoc)
     * @see com.wiredbraincoffee.reward.service.abstracts.RewardService#applyReward(java.util.List, long)
     */
    @Override
    public RewardInformation applyReward(
            List<Product> order, long customerPoints) {
        RewardInformation rewardInformation = new RewardInformation();

        if(customerPoints >= neededPoints) {
            double orderTotal = calculateTotal(order);
            if(orderTotal > amount) {
                rewardInformation = new RewardInformation(neededPoints, amount);
            }
        }

        return rewardInformation;
    }

    
    /**
     * Get Amount
     * @return
     */
    public double getAmount() {
        return amount;
    }

      
    /**
     * Set Amount
     * @param amount
     */
    public void setAmount(double amount) {
        if(amount > 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount should be greater than zero");
        }
    }
}
