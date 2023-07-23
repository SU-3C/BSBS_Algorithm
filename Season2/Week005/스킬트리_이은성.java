 public int solution(String skill, String[] skill_trees) {
        List<String> skillOrder = new ArrayList<>();
        List<Boolean> skillVisit =new ArrayList<>();
        int index = 0;
        int answer = 0;
        for (int i = 0; i < skill.length(); i++) {
            skillOrder.add(String.valueOf(skill.charAt(i)));
            skillVisit.add(false);
        }

        for (String userSkillSet : skill_trees) {
            index =0;
            Collections.fill(skillVisit,false);
            for (int i = 0; i < userSkillSet.length(); i++) {
                String ASkill = String.valueOf(userSkillSet.charAt(i));
                if (!skillOrder.contains(ASkill)) {
                    continue;
                } else {
                    if (!skillOrder.get(index).equals(String.valueOf(userSkillSet.charAt(i)))) {
                        skillVisit.clear();
                        break;
                    } else {
                        skillVisit.set(index,true);
                        index++;
                    }
                }
            }
           answer++;
        }
        return answer;
    }
