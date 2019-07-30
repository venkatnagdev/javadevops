MAX_BUILDS = 10 // max builds to keep

def jobs = Jenkins.instance.items;

for (job in jobs) {
    println "Job: " + job.name
    def recent = job.builds.limit(MAX_BUILDS)
    println "Recent Builds: "  + recent
    println "============================="
    for (build in job.builds) {
        if (!recent.contains(build) && !build.isBuilding()) {
            println "Deleting: " + build
            build.delete()
            println ""
        }
    }
}
