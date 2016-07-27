package c.finmanager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by tomag on 10.07.2016.
 */
public class Account {
    private String description;
    private BigDecimal currentSum;
    private Set<Record> recordSet;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(BigDecimal currentSum) {
        this.currentSum = currentSum;
    }

    public Set<Record> getRecordSet() {
        return recordSet;
    }
}
