pipeline {
    agent any
    tools {
        maven 'maven363' 
    }
    environment {
        DOCKER_CREDENTIAL_ID = 'dockerhub'
        REGISTRY = 'docker.io'
    }
    stages {
        stage ('Unit test') {
            steps {
                sh 'mvn test'
            }    
        }   
        
         stage('Package') {
             steps {
                sh 'mvn package -DskipTest'
            }
         }  

         stage('Push docker image') {
             steps {
                 /*
                 script{
                    docker.withRegistry('https://docker.io', 'dockerhub') {
                        def image = docker.build("freemanpolys/youtube:v1.0.${BUILD_NUMBER}")
                        image.push()
                    }
                    */
                    withCredentials([usernamePassword(passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,credentialsId : "$DOCKER_CREDENTIAL_ID" ,)]) {
                        sh 'echo "$DOCKER_PASSWORD" | docker login $REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
                        sh 'docker push  freemanpolys/test:v1.0.${BUILD_NUMBER}'
                    }
                 }
            }
         } 

        stage('Build and Run docker image') {
             steps {
                script {
                    try {
                        sh 'docker rm -f test'
                    }catch (exc) {
                        echo 'Erreur de suppression'
                    }
                }
                sh "docker run --name test -d -p 8088:8088 freemanpolys/test:v1.0.${BUILD_NUMBER}"
            }
         }         
    }

    post {
        always {
            junit 'target/surefire-reports/**/*.xml'
            archiveArtifacts artifacts: 'target/*.jar'
        }
    }
}
