
pipeline {

    agent any

    stages {

        stage('pull-code') {

            steps {

                git credentialsId: 'jenkins', url: 'https://madhav_mahamuni@bitbucket.org/fs-bitbucket/fs_employee.git'//

            }

        }

        stage('Build') {

            steps {

                sh 'mvn clean package'//

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
                    deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '/home/fs-shubhranshu/Tomcat/apache-tomcat-9.0.78/webapps', url: 'https://localhost:8081')], contextPath: '/', war: '**/*.war'
                    //sh "sudo cp **/*.war /home/fs-shubhranshu/Tomcat/apache-tomcat-9.0.78/webapps/" 1//
            }

        }

        
    }
}