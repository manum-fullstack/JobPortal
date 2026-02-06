package com.jobportal.model;

public class Job {

    private int jobId;
    private String title;
    private String company;
    private String location;
    private String description;
    private String skills;
    private int postedBy;

    public Job(){}

    public Job(int jobId,String title,String company,String location,String description,String skills,int postedBy){
        this.jobId=jobId;
        this.title=title;
        this.company=company;
        this.location=location;
        this.description=description;
        this.skills=skills;
        this.postedBy=postedBy;
    }

    public int getJobId(){return jobId;}
    public void setJobId(int jobId){this.jobId=jobId;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}

    public String getCompany(){return company;}
    public void setCompany(String company){this.company=company;}

    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}

    public String getSkills(){return skills;}
    public void setSkills(String skills){this.skills=skills;}

    public int getPostedBy(){return postedBy;}
    public void setPostedBy(int postedBy){this.postedBy=postedBy;}
}