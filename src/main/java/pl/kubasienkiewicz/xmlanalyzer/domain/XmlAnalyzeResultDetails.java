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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XmlAnalyzeResultDetails)) return false;

        XmlAnalyzeResultDetails that = (XmlAnalyzeResultDetails) o;

        if (totalPosts != that.totalPosts) return false;
        if (totalAcceptedPosts != that.totalAcceptedPosts) return false;
        if (Double.compare(that.avgScore, avgScore) != 0) return false;
        return (firstPost != null ? firstPost.equals(that.firstPost) : that.firstPost == null) && (lastPost != null ? lastPost.equals(that.lastPost) : that.lastPost == null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = firstPost != null ? firstPost.hashCode() : 0;
        result = 31 * result + (lastPost != null ? lastPost.hashCode() : 0);
        result = 31 * result + totalPosts;
        result = 31 * result + totalAcceptedPosts;
        temp = Double.doubleToLongBits(avgScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static final class Builder {
        private LocalDateTime firstPost;
        private LocalDateTime lastPost;
        private int totalPosts;
        private int totalAcceptedPosts;
        private double avgScore;

        public Builder() {
        }

        public Builder firstPost(LocalDateTime firstPost) {
            this.firstPost = firstPost;
            return this;
        }

        public Builder lastPost(LocalDateTime lastPost) {
            this.lastPost = lastPost;
            return this;
        }

        public Builder totalPosts(int totalPosts) {
            this.totalPosts = totalPosts;
            return this;
        }

        public Builder totalAcceptedPosts(int totalAcceptedPosts) {
            this.totalAcceptedPosts = totalAcceptedPosts;
            return this;
        }

        public Builder avgScore(double avgScore) {
            this.avgScore = avgScore;
            return this;
        }

        public XmlAnalyzeResultDetails build() {
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
