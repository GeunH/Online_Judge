function solution(absolutes, signs) {
    let answer = 0;
    for ( let i in absolutes){
        if(signs[i] === true){
            answer += absolutes[i];
        }
        else{
            answer -= absolutes[i];   
        }
    }
    return answer;
}