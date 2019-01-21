package com.wiredbraincoffee.reward.service;

import java.util.List;

import com.wiredbraincoffee.product.entity.Product;
import com.wiredbraincoffee.reward.entity.RewardInformation;

public abstract class RewardServiceAbstract {
    protected long neededPoints;

    public abstract RewardInformation applyReward(
            List<Product> order, long customerPoints);

    /**
     * Calculate total price of products.
     * @param order
     * @return
     */
    protected double calculateTotal(List<Product> order) {
        double sum = 0;

        if(order != null) {
            sum = order.stream().mapToDouble(Product::getPrice).sum();
        }

        return sum;
    }

    public long getNeededPoints() {
        return neededPoints;
    }

    public void setNeededPoints(long neededPoints) {
        this.neededPoints = neededPoints;
    }
}
