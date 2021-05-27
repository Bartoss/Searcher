package pl.sarata.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Rank implements Comparable<Rank>{
    private BigDecimal score;
    private String nameOfFile;

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    @Override
    public String toString() {
        return nameOfFile + " : " + score.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP) + "%";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return score.setScale(2,RoundingMode.HALF_UP).equals(rank.score.setScale(2,RoundingMode.HALF_UP)) && nameOfFile.equals(rank.nameOfFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, nameOfFile);
    }

    @Override
    public int compareTo(Rank o) {
        if(getScore() == null ||o.getScore() == null){
            return 0;
        }
        return getScore().compareTo(o.getScore());
    }
}
