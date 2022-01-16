package com.dorizu.github

import com.dorizu.github.core.data.source.remote.response.DetailUserResponse
import com.dorizu.github.core.data.source.remote.response.RepositoryUserResponse
import com.dorizu.github.core.data.source.remote.response.UserGithubResponse
import com.dorizu.github.utils.DataMapper
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

@ExperimentalCoroutinesApi
class MainActivityUnitTest {

    @Test
    fun mapSearchUserResponseToDomain() = runBlocking {
        //fake remote data
        val userResponse = UserGithubResponse(
            login = "syarif",
            id = 3224283,
            nodeId = "MDQ6VXNlcjMyMjQyODM=",
            avatarUrl = "https://avatars.githubusercontent.com/u/3224283?v=4",
            gravatarId = "",
            url = "https://api.github.com/users/syarif",
            htmlUrl = "https://github.com/syarif",
            followersUrl = "https://api.github.com/users/syarif/followers",
            followingUrl = "https://api.github.com/users/syarif/following{/other_user}",
            gistsUrl = "https://api.github.com/users/syarif/gists{/gist_id}",
            starredUrl = "https://api.github.com/users/syarif/starred{/owner}{/repo}",
            subscriptionsUrl = "https://api.github.com/users/syarif/subscriptions",
            organizationsUrl = "https://api.github.com/users/syarif/orgs",
            reposUrl = "https://api.github.com/users/syarif/repos",
            eventsUrl = "https://api.github.com/users/syarif/events{/privacy}",
            receivedEventsUrl = "https://api.github.com/users/syarif/received_events",
            type = "User",
            siteAdmin = false,
            score = 1.0
        )

        // data user in layer domain
        val userDomain = DataMapper.mapListUserResponseToDomain(listOf(userResponse)).first()

        assertEquals(
            "remote user id is same as the Domain user id.",
            userDomain.id,
            userResponse.id
        )

        assertEquals(
            "remote user username is same as the Domain user username.",
            userDomain.login,
            userResponse.login
        )

        assertEquals(
            "remote user avatarUrl is same as the Domain user avatarUrl.",
            userDomain.avatarUrl,
            userResponse.avatarUrl
        )
    }

    @Test
    fun mapDetailUserResponseToDomain() = runBlocking {
        //fake remote data
        val detailUserResponse = DetailUserResponse(
            login = "syarif",
            id = 3224283,
            nodeId = "MDQ6VXNlcjMyMjQyODM=",
            avatarUrl = "https://avatars.githubusercontent.com/u/3224283?v=4",
            gravatarId = "",
            url = "https://api.github.com/users/syarif",
            htmlUrl = "https://github.com/syarif",
            followersUrl = "https://api.github.com/users/syarif/followers",
            followingUrl = "https://api.github.com/users/syarif/following{/other_user}",
            gistsUrl = "https://api.github.com/users/syarif/gists{/gist_id}",
            starredUrl = "https://api.github.com/users/syarif/starred{/owner}{/repo}",
            subscriptionsUrl = "https://api.github.com/users/syarif/subscriptions",
            organizationsUrl = "https://api.github.com/users/syarif/orgs",
            reposUrl = "https://api.github.com/users/syarif/repos",
            eventsUrl = "https://api.github.com/users/syarif/events{/privacy}",
            receivedEventsUrl = "https://api.github.com/users/syarif/received_events",
            type = "User",
            siteAdmin = false,
            name = "Syarif Hidayat",
            company = null,
            blog = "",
            location = null,
            email = null,
            hireable = null,
            bio = "Student Tel-U",
            twitterUsername = null,
            publicRepos = 0,
            publicGists = 0,
            followers = 0,
            following = 0,
            createdAt = "2013-01-09T09:35:14Z",
            updatedAt = "2015-04-07T23:37:05Z"
        )

        // data user in layer domain
        val detailUserDomain = DataMapper.mapDetailUserResponseToDomain(detailUserResponse)

        assertEquals(
            "remote user name is same as the Domain user name.",
            detailUserResponse.name,
            detailUserDomain.name
        )

        assertEquals(
            "remote user username is same as the Domain user username.",
            detailUserResponse.login,
            detailUserDomain.username
        )

        assertEquals(
            "remote user avatarUrl is same as the Domain user avatarUrl.",
            detailUserResponse.avatarUrl,
            detailUserDomain.avatarUrl
        )

        assertEquals(
            "remote user bio is same as the Domain user bio.",
            detailUserResponse.bio,
            detailUserDomain.bio
        )
    }

    @Test
    fun mapRepoUserResponseToDomain() = runBlocking {
        //fake remote data
        val repoUserResponse = RepositoryUserResponse(
            id = 235550745,
            nodeId = "MDEwOlJlcG9zaXRvcnkyMzU1NTA3NDU=",
            name = "Android-Plat-Nomor-Scanner",
            fullName = "dodyrifkisuraya/Android-Plat-Nomor-Scanner",
            jsonMemberPrivate = false,
            htmlUrl = "https://github.com/dodyrifkisuraya/Android-Plat-Nomor-Scanner",
            description = "Android Plat Nomor Scanner",
            fork = true,
            url = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner",
            forksUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/forks",
            keysUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/keys{/key_id}",
            collaboratorsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/collaborators{/collaborator}",
            teamsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/teams",
            hooksUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/hooks",
            issueEventsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/issues/events{/number}",
            eventsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/events",
            assigneesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/assignees{/user}",
            branchesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/branches{/branch}",
            tagsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/tags",
            blobsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/git/blobs{/sha}",
            gitTagsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/git/tags{/sha}",
            gitRefsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/git/refs{/sha}",
            treesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/git/trees{/sha}",
            statusesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/statuses/{sha}",
            languagesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/languages",
            stargazersUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/stargazers",
            contributorsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/contributors",
            subscribersUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/subscribers",
            subscriptionUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/subscription",
            commentsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/commits{/sha}",
            gitCommitsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/git/commits{/sha}",
            issueCommentUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/issues/comments{/number}",
            contentsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/contents/{+path}",
            compareUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/compare/{base}...{head}",
            mergesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/merges",
            archiveUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/{archive_format}{/ref}",
            downloadsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/downloads",
            issuesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/issues{/number}",
            pullsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/pulls{/number}",
            milestonesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/milestones{/number}",
            notificationsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/notifications{?since,all,participating}",
            labelsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/labels{/name}",
            releasesUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/releases{/id}",
            deploymentsUrl = "https://api.github.com/repos/dodyrifkisuraya/Android-Plat-Nomor-Scanner/deployments",
            createdAt = "2020-01-22T10:35:13Z",
            updatedAt = "2020-01-22T10:35:15Z",
            pushedAt = "2020-01-03T05:20:35Z",
            gitUrl = "git://github.com/dodyrifkisuraya/Android-Plat-Nomor-Scanner.git",
            sshUrl = "git@github.com:dodyrifkisuraya/Android-Plat-Nomor-Scanner.git",
            cloneUrl = "https://github.com/dodyrifkisuraya/Android-Plat-Nomor-Scanner.git",
            svnUrl = "https://github.com/dodyrifkisuraya/Android-Plat-Nomor-Scanner",
            homepage = null,
            size = 150,
            stargazersCount = 0,
            watchersCount = 0,
            language = null,
            hasIssues = false,
            hasProjects = true,
            hasDownloads = true,
            hasWiki = true,
            hasPages = false,
            forksCount = 0,
            mirrorUrl = null,
            archived = false,
            disabled = false,
            openIssuesCount = 0,
            license = null,
            allowForking = true,
            isTemplate = false,
            visibility = "public",
            forks = 0,
            openIssues = 0,
            watchers = 0,
            defaultBranch = "master"
        )

        // data user in layer domain
        val repoUserDomain =
            DataMapper.mapListRepositoryResponseToDomain(listOf(repoUserResponse)).first()

        assertEquals(
            "remote repo user name is same as the Domain repo user name.",
            repoUserResponse.name,
            repoUserDomain.name
        )

        assertEquals(
            "remote repo user description is same as the Domain repo user description.",
            repoUserResponse.description,
            repoUserDomain.description
        )

        assertEquals(
            "remote repo user starCount is same as the Domain repo user starCount.",
            repoUserResponse.stargazersCount,
            repoUserDomain.stargazersCount
        )

        assertEquals(
            "remote repo user lastUpdate is same as the Domain repo user lastUpdate.",
            repoUserResponse.updatedAt,
            repoUserDomain.updatedAt
        )
    }
}