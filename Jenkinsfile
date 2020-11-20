pipeline{
agent any
stages{
stage("Build Stage"){
echo "Building dev branch"
    steps('maven config'){
        withMaven(maven:'maven_3_6_1')
        bat "mvn clean package"
    }
}
}
}