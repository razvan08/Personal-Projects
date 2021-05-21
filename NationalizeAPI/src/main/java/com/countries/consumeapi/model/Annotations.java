package com.countries.consumeapi.model;

import java.net.URL;
import java.util.UUID;

public class Annotations {
    private String source_name;
    private String source_description;
    private String dataset_name;
    private URL dataset_link;
    private UUID table_id;
    private String topic;
    private String subtopic;

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getSource_description() {
        return source_description;
    }

    public void setSource_description(String source_description) {
        this.source_description = source_description;
    }

    public String getDataset_name() {
        return dataset_name;
    }

    public void setDataset_name(String dataset_name) {
        this.dataset_name = dataset_name;
    }

    public URL getDataset_link() {
        return dataset_link;
    }

    public void setDataset_link(URL dataset_link) {
        this.dataset_link = dataset_link;
    }

    public UUID getTable_id() {
        return table_id;
    }

    public void setTable_id(UUID table_id) {
        this.table_id = table_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }
}
