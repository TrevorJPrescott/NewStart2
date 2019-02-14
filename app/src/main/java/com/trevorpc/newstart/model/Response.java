package com.trevorpc.newstart.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    private Integer duration;

    private Integer risetime;

    public Response(Integer duration, Integer risetime){
        this.duration = duration;
        this.risetime = risetime;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getRisetime() {
        return risetime;
    }
}