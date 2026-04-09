from collections import defaultdict
def solution(id_list, report, k):
    report_count = defaultdict(int)
    report_id = defaultdict(list)
    report = list(set(report))
    for r in report:
        a = r.split(' ')[0]
        b = r.split(' ')[1]
        report_count[b] += 1
        report_id[b].append(a)
        
    ids = {}
    for i,id in enumerate(id_list):
        ids[id] = {'index':i, 'count':0}
        
    for id,count in report_count.items():
        if(count>=k):
            for r in report_id[id]:
                ids[r]['count'] += 1
            
    result = []
    sorted_ids = sorted(ids.items(), key=lambda x: x[1]['index'])
    for id in sorted_ids:
        result.append(id[1]['count'])
        
    return result