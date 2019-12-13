package pl.altkomsoftware.lab.ebidder.listings.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Embeddable
@Getter
public class Money implements Comparable<Money> {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = new BigDecimal(String.valueOf(amount), new MathContext(4, RoundingMode.HALF_EVEN));
    }

    public static Money zero() {
        return from(new BigDecimal("0.00"));
    }

    public static Money from(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount for Money cannot be null");
        }
        return new Money(amount);
    }

    public static Money from(String amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount for Money cannot be null");
        }
        return new Money(new BigDecimal(amount));
    }

    public static Money from(Integer amount) {
        if (amount == null) {
            throw new RuntimeException("Amount for Money cannot be null");
        }
        return new Money(new BigDecimal(amount));
    }

    protected Money() {
        this.amount = BigDecimal.ZERO;
    }

    public Money add(Money momeny) {
        if (momeny == null) {
            throw new IllegalArgumentException("Cant add null money");
        }
        return new Money(amount.add(momeny.toBigDecimal()));
    }

    public Money subtract(Money money) {
        if (money == null) {
            throw new IllegalArgumentException("Cant subtract null money");
        }

        return new Money(amount.subtract(money.toBigDecimal()));
    }

    public boolean isPositive() {
        return amount.signum() == 1;
    }

    public boolean isNegative() {
        return amount.signum() == -1;
    }

    public boolean isZero() {
        return amount.signum() == 0;
    }

    public boolean isPositiveOrZero() {
        return isPositive() || isZero();
    }

    public boolean isNegativeOrZero() {
        return isNegative() || isZero();
    }

    public boolean greaterThan(Money money) {
        return this.compareTo(money) == 1;
    }

    public boolean greaterOrEqual(Money money) {
        return this.compareTo(money) >= 0;
    }

    public boolean lowerThan(Money money) {
        return this.compareTo(money) == -1;
    }

    public boolean lowerOrEqual(Money money) {
        return this.compareTo(money) <= 0;
    }

    public boolean equalTo(Money money) {
        return this.compareTo(money) == 0;
    }

    public Money toWholeNumber() {
        return new Money(amount.setScale(0, RoundingMode.HALF_UP));
    }

    public Money round(int numerOfDecimalPlaces) {
        return new Money(amount.setScale(numerOfDecimalPlaces, RoundingMode.HALF_UP));
    }

    public static Money min(Money first, Money second) {
        return first.compareTo(second) < 0 ? first : second;
    }

    public static Money max(Money first, Money second) {
        return first.compareTo(second) >= 0 ? first : second;
    }

    public Money multiply(BigDecimal multiplier) {
        return new Money(amount.multiply(multiplier));
    }

    public Money multiply(Integer multiplier) {
        return new Money(amount.multiply(BigDecimal.valueOf(multiplier)));
    }

    public Money multiply(BigDecimal multiplier, RoundingMode rounding) {
        BigDecimal multiplication = amount.multiply(multiplier);
        return new Money(multiplication.setScale(2, rounding));
    }

    public BigDecimal toBigDecimal() {
        return new BigDecimal(amount.toString());// amount;
    }

    @Override
    public int compareTo(Money o) {
        return amount.compareTo(o.getAmount());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Money)) {
            return false;
        }
        return amount.equals(((Money) object).toBigDecimal());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 29 + amount.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);

        return df.format(this.amount);
    }
}
