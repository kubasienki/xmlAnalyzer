package pl.kubasienkiewicz.xmlanalyzer.domain;

import java.time.LocalDateTime;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
public class XmlAnalyzeResultDetails {

    private LocalDateTime firstPost;
    private LocalDateTime lastPost;
    private int totalPosts;
    private int totalAcceptedPosts;
    private double avgScore;

    private XmlAnalyzeResultDetails(){

    }

    public LocalDateTime getFirstPost() {
        return firstPost;
    }

    public LocalDateTime getLastPost() {
        return lastPost;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public int getTotalAcceptedPosts() {
        return totalAcceptedPosts;
    }

    public double getAvgScore() {
        return avgScore;
    }

    static final class Builder {
        private LocalDateTime firstPost;
        private LocalDateTime lastPost;
        private int totalPosts;
        private int totalAcceptedPosts;
        private double avgScore;

        Builder() {
        }

        Builder firstPost(LocalDateTime firstPost) {
            this.firstPost = firstPost;
            return this;
        }

        Builder lastPost(LocalDateTime lastPost) {
            this.lastPost = lastPost;
            return this;
        }

        Builder totalPosts(int totalPosts) {
            this.totalPosts = totalPosts;
            return this;
        }

        Builder totalAcceptedPosts(int totalAcceptedPosts) {
            this.totalAcceptedPosts = totalAcceptedPosts;
            return this;
        }

        Builder avgScore(double avgScore) {
            this.avgScore = avgScore;
            return this;
        }

        XmlAnalyzeResultDetails build() {
            XmlAnalyzeResultDetails xmlAnalyzeResultDetails = new XmlAnalyzeResultDetails();
            xmlAnalyzeResultDetails.lastPost = this.lastPost;
            xmlAnalyzeResultDetails.firstPost = this.firstPost;
            xmlAnalyzeResultDetails.avgScore = this.avgScore;
            xmlAnalyzeResultDetails.totalAcceptedPosts = this.totalAcceptedPosts;
            xmlAnalyzeResultDetails.totalPosts = this.totalPosts;
            return xmlAnalyzeResultDetails;
        }
    }
}
