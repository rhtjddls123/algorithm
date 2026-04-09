from collections import defaultdict

def solution(genres, plays):
    genres_dict = defaultdict(int)
    for g,p in zip(genres, plays):
        genres_dict[g] += p
    
    sorted_genres = sorted(genres_dict.items(), key=lambda x:x[1], reverse=True)
    
    genre_play = list(enumerate(zip(genres, plays)))
    sorted_genre_play = sorted(genre_play, key=lambda x: x[1][1], reverse=True)
    
    play_dict = defaultdict(list)
    for i in sorted_genre_play:
        play_dict[i[1][0]].append(i[0])
    
    result = []
    
    for g in sorted_genres:
        genre = g[0]
        result.append(play_dict[genre].pop(0))
        if(len(play_dict[genre])>=1):
            result.append(play_dict[genre].pop(0))
            
    return result