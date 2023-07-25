pipeline {
    agent any
        stages {
        stage('Project Pull') {
            steps {
                git credentialsId: '1be069cb-c887-4f99-9591-0b5955b5c4e9', url: 'https://nidhisinha288@bitbucket.org/fs-bitbucket/fs_employee.git'
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