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

# 
# Jason Perez
# Tested with Python version: 2.7.15rc1
# Machine information: [MSC v.1500 64 bit (AMD64)]
# How to run:
# In terminal, press:
# python code.py
# Enter "yes" or "no" in prompt then follow further instructions.
# Once finished, parents and activites data will be printed through the terminal.

# Cycles through available data for parents, children and num_of_activities
# If activities are not found, the terminal will display an error message
def cycle_through():

        for parent in parents:
            try:
                age_no = parents[parent]['age']
                print("\nDear " + parent + ", your activities are the following: ")
                # Boolean to verify whether activities were printed to the terminal
                message = False

                # Cycle through available data
                for i in range(0, len(activities)):
                    if (age_no == activities[i]['age']):
                        activity = (activities[i]['activity'])
                        message = True
                        for act in activity:
                            # Print activity found for child age
                            print(act)

                # If no activties found for child age, display this message
                if message == False:
                    print("Error, no activities present for age of "  + parents[parent]['childName'] + ".")
                else:
                    print("Curriculum complete!")

            # If child information not found, display this message
            except KeyError:
                print("\nError, no child data found for " + parent + ".")

# Collects information of new parent from user
def parent_entry():

    # Keep adding new parents unless told otherwise
    while True:

        name_of_parent = raw_input("Enter name of parent: ")
        name_of_child = raw_input("Enter name of child: ")
        age_of_child = int(raw_input("Enter age of " + name_of_child + ": "))
        parents[name_of_parent] = {'childName': name_of_child, 'age': age_of_child}
        user_input = raw_input("Would you like to enter additional parents? (yes/no): ")

        if (user_input == "no"):
            cycle_through()
            break

# Collects information of new activities from user
def activity_entry():

    while True:

        age_of_activity = int(raw_input("Enter activity age: "))
        num_of_activities = int(raw_input("How many activities would you like to add?: "))
        list_of_activities = []

        # Add all activities into a list
        for iteration in range(0, num_of_activities):
            activity = raw_input("Activity " + str(iteration + 1) + ": ")
            list_of_activities.append(activity)

        # Boolean to verify if list already exists for desired age
        existing_list = False
        for i in range(0, len(activities)):
            # Append to preexisting activity list
            if (age_of_activity == activities[i]['age']):
                existing_list = True
                # Append new activities to existing list of activities
                activities[i]['activity'] = activities[i]['activity'] + list_of_activities

        # Store new list
        if existing_list == False:
            activities.append({'age': age_of_activity, 'activity': list_of_activities})

        user_input = raw_input("Would you like to enter additional activities? (yes/no): ")

        if (user_input == "no"):
            cycle_through()
            break

def main():

    user_input = raw_input("Dear user, would you like to input additional parents and activities? (yes/no): ")

    # Enter either parent or activity data otherwise, cycle through parents and activities data
    if (user_input == "yes"):
        user_input = raw_input("Would you like to enter parent or activity data? (parent/activity): ")
        if (user_input == "parent"):
            parent_entry()
        elif (user_input == "activity"):
            activity_entry()
    else:
        cycle_through()

if __name__ == "__main__":
    main()
