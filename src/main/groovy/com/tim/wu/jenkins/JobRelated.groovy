package com.tim.wu.jenkins

import hudson.model.AbstractProject
import jenkins.model.Jenkins

/**
 * Created by etigwuu on 2016/1/26.
 */
class JobRelated {

    /**
     * Disable all jenkins jobs
     */
    def disableAllJob(){
        def jobs = Jenkins.instance.getAllItems(AbstractProject.class)
        jobs.each {
            println "Disable job " + it.getDisplayName()
            it.disable()
            println "Job " + it.getDisplayName() + " status is " + it.isDisabled()
            println ""
        }
    }
    /**
     * Disables a job based on the name
     *
     * @param name Job name
     * @return true if the job is in disabled status, return false otherwise
     */
    def disableJob(String name){
        def result = Jenkins.instance.getItemByFullName(name)
        //TODO Seems work flow dont follow this
        result.disable()
        return result.isDisabled()
    }
}
