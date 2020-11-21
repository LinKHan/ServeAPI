pipeline{
agent any
stages{
stage('Build Stage')
    steps('maven config'){
        withMaven(maven:'maven_3_6_1')
        bat "mvn clean package"
    }
}
}
}