package br.com.binsolution.ecs_fargate_cdk_01.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(results, user.results);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(results);
    }

    @Override
    public String toString() {
        return "User{" +
                "results=" + results +
                '}';
    }
}
