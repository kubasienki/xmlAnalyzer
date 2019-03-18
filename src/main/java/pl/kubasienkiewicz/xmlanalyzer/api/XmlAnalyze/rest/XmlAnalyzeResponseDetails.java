package pl.kubasienkiewicz.xmlanalyzer.api.XmlAnalyze.rest;

import java.time.LocalDateTime;

/**
 * Created by Jakub Sienkiewicz on 15.03.2019.
 */
class XmlAnalyzeResponseDetails {

    private LocalDateTime firstPost;
    private LocalDateTime lastPost;
    private int totalPosts;
    private int totalAcceptedPosts;
    private double avgScore;

    private XmlAnalyzeResponseDetails(){

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

        XmlAnalyzeResponseDetails build() {
            XmlAnalyzeResponseDetails xmlAnalyzeResponseDetails = new XmlAnalyzeResponseDetails();
            xmlAnalyzeResponseDetails.totalPosts = this.totalPosts;
            xmlAnalyzeResponseDetails.lastPost = this.lastPost;
            xmlAnalyzeResponseDetails.firstPost = this.firstPost;
            xmlAnalyzeResponseDetails.totalAcceptedPosts = this.totalAcceptedPosts;
            xmlAnalyzeResponseDetails.avgScore = this.avgScore;
            return xmlAnalyzeResponseDetails;
        }
    }
}
