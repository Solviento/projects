# Without directly modifying the data structures, create a script in either
# python or javascript that cycles through all the parents and prints to the
# terminal the proper activities for their child's age group. When there are no
# more activities for that parent, print Curriculum complete!..
#
# (Make sure your script accounts for any edge cases in the provided data!)

parents = {
    'Henry': {'childName': 'Calvin', 'age': 1},
    'Ada': {'childName': 'Lily', 'age': 4},
    'Emilia': {'childName': 'Petra', 'age': 2},
    'Biff': {'childName': 'Biff Jr', 'age': 3},
    'Milo': {}
}

activities = [
    {
        'age': 1,
        'activity': [
            'Go outside and feel surfaces.',
            'Try singing a song together.',
            'Point and name objects.'
            ]
    },
    {
        'age': 2,
        'activity': [
            'Draw with crayons.',
            'Play with soundmaking toys or instruments.',
            'Look at family pictures together.'
            ]
    },
    {
        'age': 3,
        'activity': [
            'Build with blocks.',
            'Try a simple puzzle.',
            'Read a story together.'
            ]
    }
]

# Want to really shine and show us your chops?  Work in some of these stretch
# goals using any tools or libraries you see fit.
# - Document your creation process with proper git workflow.
# - Personalize the message output to make it more friendly.
# - Allow users to input new activities & parents before executing the script.
# - Print one activity at a time per parent and continue cycling through until
#   all parents have recieved all their activities.
import json

def main():
    str_data = json.dumps(parents)
    parents_data = json.loads(str_data)

    # num_of_parents = len(parent_data)
    for parent in parents_data:
        try:
            # print(parents_data[parent]['childName'])
            age_no = parents_data[parent]['age']
            print("Dear " + parent + ", your activities are the following: ")
            for i in range(0, len(activities)):
                if (age_no == activities[i]['age']):
                    activity = (activities[i]['activity'])
                    print(activity)
                    print("")

        except KeyError:
            print("Error, no child data found for " + parent + ".\n")

if __name__ == "__main__":
    main()
