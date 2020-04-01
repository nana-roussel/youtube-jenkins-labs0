def mvn
node {
    stage('Get tools') {
        def maven_home = tool 'maven363'
        mvn = "${maven_home}/bin/mvn"
    }
    stage('Get maven version') { 
        sh "${mvn} --version"
    }       
}