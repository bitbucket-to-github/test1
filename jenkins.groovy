pipeline {
    agent any
        stages {
        stage('Project Pull') {
            steps {
                git url: 'https://nidhisinha288@bitbucket.org/fs-bitbucket/fs_employee.git'
                echo 'project pull sucessfully by pipeline'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('test') {
            steps {
                withSonarQubeEnv('sonar') {
                  sh 'mvn sonar:sonar'
                    }
            }
        }
    }
}