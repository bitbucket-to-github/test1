pipeline {

    agent any

    stages {

        stage('pull-code') {

            steps {

                git credentialsId: 'jenkins', url: 'https://madhav_mahamuni@bitbucket.org/fs-bitbucket/fs_employee.git'

            }

        }

        stage('Build') {

            steps {

                sh 'mvn clean package'

            }

        }

        stage('Test') {

            steps('SonarQube Analysis') {
                
                withSonarQubeEnv('sonarserver') {

                    sh "mvn sonar:sonar"

                }

            }
        }

        stage('Deploy') {

            steps {
                    sh "sudo cp -r /var/lib/jenkins/workspace/ci-cd pipeline/target/studentapp-2.2-SNAPSHOT.war /home/fs-shubhranshu/Tomcat/apache-tomcat-9.0.78/webapps"
                    //deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '/home/fs-shubhranshu/Tomcat/webapps', url: 'http://localhost:8081')], contextPath: '/', war: '/var/lib/jenkins/workspace/ci-cd pipeline/target/*.war'

            }

        }

        
    }
}