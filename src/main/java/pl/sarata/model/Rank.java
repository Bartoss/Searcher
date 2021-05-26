package pl.sarata.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Rank {
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
        return nameOfFile + " : " + score + "%";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return score.equals(rank.score) && nameOfFile.equals(rank.nameOfFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, nameOfFile);
    }
}
