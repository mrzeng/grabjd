/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grap.dto;

/**
 *
 * @author cz
 */
public class Link {
     
    private long id;
    
    private String linkUrl;
    
    private String linkName;
    
    private long period;
    
    private long etime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public long getEtime() {
        return etime;
    }

    public void setEtime(long etime) {
        this.etime = etime;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    
    
}
