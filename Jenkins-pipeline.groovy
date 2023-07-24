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

                def mvn = tool 'Default Maven';

                withSonarQubeEnv('sonarserver') {

                    sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=fs-bitbucket_fs_employee_AYlPLJp_qqhibVYfSfU_"

                }

            }
        }

        stage('Deploy') {

            steps {

                    deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '/home/fs-shubhranshu/Tomcat/webapps', url: 'http://localhost:8081')], contextPath: '/', war: '**/target/*.war'

            }

        }

        
    }
}