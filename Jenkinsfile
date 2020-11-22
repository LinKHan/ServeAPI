pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
            checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '1d95bc8f-0c98-4683-a76d-917395be0799', url: 'https://github.com/LinKHan/ServeAPI.git']]])
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('Deplooy'){
            steps{
                deploy adapters: [tomcat9(credentialsId: '97921461-b092-4aea-b1e3-7045a9161640', path: '', url: 'http://localhost:8082/')], contextPath: null, war: '**/*.war'
            }
        }
    }
}
