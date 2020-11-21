pipeline{
agent any
stages{
stage('Build Stage')
    steps('maven config'){
        bat "mvn clean package"
    }
}
}
